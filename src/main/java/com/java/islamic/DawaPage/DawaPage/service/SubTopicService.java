/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.islamic.DawaPage.DawaPage.service;

import com.java.islamic.DawaPage.DawaPage.entity.Sub_topic;
import com.java.islamic.DawaPage.DawaPage.entity.Topic;
import com.java.islamic.DawaPage.DawaPage.repository.CommentRepository;
import com.java.islamic.DawaPage.DawaPage.repository.SubTopicRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KEMAL
 */
@Repository
public class SubTopicService {

    @Autowired
    public SubTopicRepository subtopicRepository;

    public List<Sub_topic> getByTopicFK(Long id) {
        return subtopicRepository.findByfkTopic(id);
    }

    public Sub_topic getSubTopic(Long id) {
        return (subtopicRepository.findById(id)).get();
    }

    public void saveSubTopic(Sub_topic topic) {
        subtopicRepository.save(topic);
    }

    public void removeSubTopic(Sub_topic topic) {
        subtopicRepository.delete(topic);
    }

    public void removeSubTopic(Long id) {
        subtopicRepository.deleteById(id);
    }

    public List<Sub_topic> getAllTopic() {
        return subtopicRepository.findAll();
    }

    public boolean subtopicExist(String name) {

        if (subtopicRepository.findByName(name) == null) {
            return false;
        } else {
            return true;
        }
    }

}
