import com.djb.aixiao.mapper.TbUserMapper;
import com.djb.aixiao.pojo.TbUserExample;
import com.djb.aixiao.pojo.UserAndRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author djb
 * @create 2019-06-01 22:21
 */
public class UserAndRoleTest {

    @Autowired
    private TbUserMapper userMapper;

    @Test
    public void test(){

        TbUserExample example = new TbUserExample();
//        example.createCriteria().andClassesIdEqualTo(1192l);
        List<UserAndRole> userAndRoleList = userMapper.getUserAndRoleByExample(example);
        for (UserAndRole userAndRole : userAndRoleList) {
            System.out.println(userAndRole.getRoleName());

        }

    }
}
