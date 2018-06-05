
import com.zhou.wise.manager.service.IPackageVersionService;
import com.zhou.wise.manager.web.WiseManagerWebApplication;
import com.zhou.wise.pojo.PackageVersion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WiseManagerWebApplication.class)
public class WiseManagerWebApplicationTest {

    @Resource
    IPackageVersionService packageVersionService;

    @Test
    public void insertTest(){

        Map<String,String> map = new HashMap<>();
        map.put("hVender","default");
        map.put("hModel","default");

        PackageVersion packageVersion = packageVersionService.findByParam("selectByStatus_1", map);
        System.out.println("packageVersion="+packageVersion);
        System.out.println("packageVersion.gethPackagename()="+packageVersion.gethPackagename());
    }
}
