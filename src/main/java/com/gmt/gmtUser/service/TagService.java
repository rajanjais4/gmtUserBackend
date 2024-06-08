package com.gmt.gmtUser.service;

import com.gmt.gmtUser.model.common.Tag;
import com.gmt.gmtUser.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private SequenceService sequenceService;

    public Tag createTag(Tag tag) {
        tag.setId(Long.toString(sequenceService.getNextSequence("tags_sequence")));
        return tagRepository.save(tag);
    }

    public Tag updateTag(String id, Tag tagDetails) {
        Optional<Tag> tagOptional = tagRepository.findById(id);
        if (tagOptional.isPresent()) {
            Tag tag = tagOptional.get();
            tag.setName(tagDetails.getName());
            tag.setType(tagDetails.getType());
            tag.setPopularity(tagDetails.getPopularity());
            return tagRepository.save(tag);
        }
        return null;
    }

    public void deleteTag(String id) {
        tagRepository.deleteById(id);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getTagById(String id) {
        return tagRepository.findById(id);
    }
}