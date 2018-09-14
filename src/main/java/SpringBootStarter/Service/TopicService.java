package SpringBootStarter.Service;

import SpringBootStarter.Model.Topic;
import SpringBootStarter.Repositary.TopicRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepositary topicRepositary;

    /*private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1","Spring Framework","Description of Framework"),
                new Topic("2","Yii Framework","Description of Framework"),
                new Topic("3","Laravel Framework","Description of Framework")

        ));*/
    public List<Topic> getAllTopics(){
        /*List<Topic> topics = new ArrayList<>();
        topicRepositary.findAll().forEach(topics::add);
        return topics;*/
        return topicRepositary.findAll();
    }

    public Topic getTopic(Long id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepositary.findOne(id);
    }

    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepositary.save(topic);
    }

    public void updateTopic(Long id, Topic topic){
        /*for (int i=0; i < topics.size(); i++){
            Topic t =topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }*/
        Topic topicUpdated = topicRepositary.findOne(topic.getId());

        topicUpdated.setName(topic.getName());
        topicUpdated.setDescription(topic.getDescription());
        topicRepositary.save(topicUpdated);
    }

    public void deleteTopic(Long id){
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepositary.delete(id);
    }
}
