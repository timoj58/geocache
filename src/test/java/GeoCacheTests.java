import com.timmytime.geocache.GeoCacheConverter;
import com.timmytime.request.GeoCacheRequest;
import org.junit.Test;
import com.timmytime.reponse.GeoCacheResponse;
import com.timmytime.util.GeoCacheUtils;

import static org.junit.Assert.assertEquals;

public class GeoCacheTests {


    @Test
    public void geoCacheTest(){


        //need some strong cases for this when i cba...
        GeoCacheResponse geoCacheResponse = GeoCacheConverter.convert(new GeoCacheRequest(40.0, 25.0));

        assertEquals("T35", geoCacheResponse.getUtm().toString());
        assertEquals("1C10", geoCacheResponse.getSubUtm().toString());

        geoCacheResponse = GeoCacheConverter.convert(new GeoCacheRequest(-34.0, -34.0));


        assertEquals("H25", geoCacheResponse.getUtm().toString());
        assertEquals("7C20", geoCacheResponse.getSubUtm().toString());

        geoCacheResponse = GeoCacheConverter.convert(new GeoCacheRequest(0.0, 0.0));

        assertEquals("N31", geoCacheResponse.getUtm().toString());
        assertEquals("1C0", geoCacheResponse.getSubUtm().toString());


    }

}
