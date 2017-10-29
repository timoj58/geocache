package com.timmytime.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.timmytime.model.UTM;

import java.util.Calendar;
import java.util.Date;

public class GeoCacheResponse {

    private UTM utm;
    private UTM subUtm;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date created;

    public GeoCacheResponse(UTM utm, UTM subUtm){
        this.utm = utm;
        this.subUtm = subUtm;
    }

    public UTM getUtm() {
        return utm;
    }

    public void setUtm(UTM utm) {
        this.utm = utm;
    }

    public UTM getSubUtm() {
        return subUtm;
    }

    public void setSubUtm(UTM subUtm) {
        this.subUtm = subUtm;
    }

    public Date getCreated() {
        return Calendar.getInstance().getTime();
    }

    @Override
    public String toString(){

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try {
            return  mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }

    }
}
