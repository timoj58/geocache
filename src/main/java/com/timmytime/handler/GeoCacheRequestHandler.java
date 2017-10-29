package com.timmytime.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timmytime.geocache.GeoCacheConverter;
import com.timmytime.reponse.GeoCacheResponse;
import com.timmytime.request.GeoCacheRequest;



public class GeoCacheRequestHandler implements RequestHandler<GeoCacheRequest, GeoCacheResponse> {

    @Override
    public GeoCacheResponse handleRequest(GeoCacheRequest geoCacheRequest, Context context) {
            return GeoCacheConverter.convert(geoCacheRequest);
    }
}
