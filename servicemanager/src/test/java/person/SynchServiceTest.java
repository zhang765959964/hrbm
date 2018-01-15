///**
// * FormServiceTest.java Create on 2014年4月17日
// * <p/>
// * Copyright  HeNan New Creatsoft. All rights reserved.
// */
//package person;
//
//
//import com.xunfeng.business.careertalk.service.CareerTalkService;
//import com.xunfeng.business.cms.service.ArticleColumnService;
//import com.xunfeng.business.cms.service.ArticleService;
//import com.xunfeng.business.corp.service.CorpService;
//import com.xunfeng.business.jobfair.service.JobFairInfoService;
//import com.xunfeng.business.person.service.PersonBaseInfoService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Filename: FormServiceTest.java<br>
// * Description:
// *
// * @author: WangHan
// * @date 2014年4月17日上午3:28:49
// * @version: 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:conf/app-context.xml"})
//public class SynchServiceTest {
//
//    @Autowired
//    private ArticleColumnService articleColumnService;
//
//    @Autowired
//    private ArticleService articleService;
//    @Autowired
//    CareerTalkService careerTalkService;
//    @Autowired
//    @Qualifier(value = "jdbcTemplateSouce")
//    JdbcTemplate jdbcTemplate;
//    @Autowired
//    CorpService  corpService;
//    @Autowired
//    JobFairInfoService  jobFairInfoService;
//    @Autowired
//    PersonBaseInfoService  personBaseInfoService;
//
//    @Test
//    public void SynchCorp() {
//
//        corpService.synchCorp();
//    }
//    //直接同步完毕
//    @Test
//    public void SynchPerson() {
//
//        personBaseInfoService.synchPerson();
//    }
//    //直接同步完毕
//    @Test
//    public void SynchCms() {
//        articleService.SynchCmsCol();
//
//    }
//
//
//    @Test
//    public void SynchZPH() {
//
//        jobFairInfoService.synchJobFairLocation();
//        jobFairInfoService.synchJobFairData();
//
//    }
////需要关联企业信息
//    @Test
//    public void SynchXJH() {
////        同步单位数据后执行该语句
////        update  CAREER_TALK t set t.ct_createby=(select a.aab001 from ab01 a where a.old_id=t.ct_createby)
//
//        careerTalkService.SynchRoom();
//    }
//}
