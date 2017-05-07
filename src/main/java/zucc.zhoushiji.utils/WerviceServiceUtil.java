package zucc.zhoushiji.utils;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.rpc.ParameterMode;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zsj on 2017/5/7.
 */
public class WerviceServiceUtil {
    public static void main(String[] args) {
        try {
            String url = "http://60.191.0.118:9010/WebService.asmx";
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setSOAPActionURI("http://tempuri.org/GetCarInfo");

            call.setTargetEndpointAddress(url);  //调用路径
            call.setOperationName("GetCarInfo"); //调用接口方法

            call.addParameter("StartTime",   //接口参数名称
                    XMLType.XSD_DATE,  //参数类型
                    ParameterMode.IN);  //参数模式 in / out

            call.addParameter("StopTime",   //接口参数名称
                    XMLType.XSD_DATE,  //参数类型
                    ParameterMode.IN);

            call.setReturnType(XMLType.XSD_STRING);  //返回数据类型

            Date[] objects = new Date[2];   //传递参数的具体内容
            objects[0] = DateUtil.stringToDate("2017-05-03 17:55:00",DateUtil.YMD_DASH_WITH_TIME);
            objects[1] = DateUtil.stringToDate("2017-05-03 18:00:00",DateUtil.YMD_DASH_WITH_TIME);


            String res = (String)call.invoke(objects); //执行

            System.out.println(res);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
