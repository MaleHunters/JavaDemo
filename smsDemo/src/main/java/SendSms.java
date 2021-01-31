import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.3</version>
</dependency>
*/

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/31 8:06
 * @Package: PACKAGE_NAME
 * @CurrentProject: smsDemo
 * @version: 1.0
 */
// 阿里云验证码测试
public class SendSms {
  public static void main(String[] args) {
    DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GDJ1XpwdLCMB9jwaYWM", "flDFO2wL1S84uh4MGrdC3UD5KW0R44");
    IAcsClient client = new DefaultAcsClient(profile);

    CommonRequest request = new CommonRequest();
    request.setSysMethod(MethodType.POST);
    request.setSysDomain("dysmsapi.aliyuncs.com");
    request.setSysVersion("2017-05-25");
    request.setSysAction("SendSms");
    request.putQueryParameter("RegionId", "cn-hangzhou");
    request.putQueryParameter("PhoneNumbers", "15662622515");
    try {
      CommonResponse response = client.getCommonResponse(request);
      System.out.println(response.getData());
    } catch (ServerException e) {
      e.printStackTrace();
    } catch (ClientException e) {
      e.printStackTrace();
    }
  }
}
