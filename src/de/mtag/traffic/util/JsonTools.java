/*
 * The MIT License
 *
 * Copyright 2015 Christian Wahlmann.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.mtag.traffic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author cwahlmann
 */
public class JsonTools {
    public static JSONObject requestService(String service) throws JsonServiceException
    {
        InputStream is = null;
        try {
            URL url = new URL(service);
            JSONParser parser = new JSONParser();
            is=url.openStream();
            JSONObject result = (JSONObject)parser.parse(new BufferedReader(new InputStreamReader(is)));
            is.close();
            return result;
        } catch (MalformedURLException ex) {
            throw new JsonServiceException("Bad service address", ex);
        } catch (IOException ex) {            
            throw new JsonServiceException("Service '"+service+"' not available.", ex);
        } catch (ParseException ex) {
            throw new JsonServiceException("Error parsind service '"+service+"'.", ex);
        }
        finally
        {
            if (is!=null)
            {
                try {
                    is.close();
                } catch (IOException ex) {
                    throw new JsonServiceException("unable to close input stream", ex);                }
            }
        }
    }

    public static Object requestPath(JSONObject root, String path)
    {
        String[] ids = path.split("\\.");
        Object obj=root;
        for (String id:ids)
        {
            if (id.contains(":"))
            {
                String[] idIndex=id.split("\\:");
                if (obj!=null && obj instanceof JSONObject && ((JSONObject)obj).containsKey(idIndex[0]))
                {
                    obj = ((JSONObject)obj).get(idIndex[0]);
                    if (obj!=null && obj instanceof JSONArray)
                    {
                        obj = ((JSONArray)obj).get(Integer.decode(idIndex[1]));
                    }
                    else
                    {
                        return null;
                    }
                }
                else
                {
                    return null;
                }
            }
            else
            {
                if (obj!=null && obj instanceof JSONObject && ((JSONObject)obj).containsKey(id))
                {
                    obj = ((JSONObject)obj).get(id);
                }
                else
                {
                    return null;
                }
            }
        }
        return obj;
    }
    
    public static Double requestDouble(JSONObject jso, String path)
    {
        Object obj=requestPath(jso, path);
        return obj != null && obj instanceof Number? ((Number)obj).doubleValue():0;
    }
    
    public static Long requestLong(JSONObject jso, String path)
    {
        Object obj=requestPath(jso, path);
        return obj != null && obj instanceof Number? ((Number)obj).longValue():0l;
    }
    
    public static Integer requestInteger(JSONObject jso, String path)
    {
        Object obj=requestPath(jso, path);
        return obj != null && obj instanceof Number? ((Number)obj).intValue():0;
    }

    public static String requestString(JSONObject jso, String path)
    {
        Object obj=requestPath(jso, path);
        return obj != null && obj instanceof String? (String)obj: "";
    }
}
