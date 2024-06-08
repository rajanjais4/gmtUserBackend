package com.gmt.gmtUser.controller;
import com.gmt.gmtUser.model.common.Tag;
import com.gmt.gmtUser.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable String id, @RequestBody Tag tagDetails) {
        Tag updatedTag = tagService.updateTag(id, tagDetails);
        if (updatedTag != null) {
            return ResponseEntity.ok(updatedTag);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable String id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable String id) {
        Optional<Tag> tag = tagService.getTagById(id);
        if (tag.isPresent()) {
            return ResponseEntity.ok(tag.get());
        }
        return ResponseEntity.notFound().build();
    }
}
