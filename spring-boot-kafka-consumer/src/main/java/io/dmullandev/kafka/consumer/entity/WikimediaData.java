package io.dmullandev.kafka.consumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 * Entity class for the Wikimedia type
 * 
 * @author dmullandev
 *
 */
@Entity
@Table(name = "wikimedia_recentChange")
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikimediaEventData;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the wikimediaEventData
     */
    public String getWikimediaEventData() {
        return wikimediaEventData;
    }

    /**
     * @param wikimediaEventData the wikimediaEventData to set
     */
    public void setWikimediaEventData(String wikimediaEventData) {
        this.wikimediaEventData = wikimediaEventData;
    }

}
