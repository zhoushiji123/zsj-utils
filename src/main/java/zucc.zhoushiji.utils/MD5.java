package zucc.zhoushiji.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by zsj on 2017/4/13.
 */
public class MD5 {
    public static String getMD5(String message){
        String md5Str = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(message.getBytes());
            md5Str = new BigInteger(1,messageDigest.digest()).toString(32);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  md5Str;
    }
}
