package com.cps;

import com.cps.pojo.Comment;
import com.cps.pojo.Scenery;
import com.cps.pojo.User;
import com.cps.service.CommentService;
import com.cps.service.SceneryService;
import com.cps.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * 测试类
 */
@SpringBootTest
class TravelApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    SceneryService sceneryService;

    @Autowired
    CommentService commentService;

    // 测试认证用户功能
    @Test
    void contextLoads1() {
        User user = userService.find("root","123");
        System.out.println(user);
    }

    // 测试查询所有景点功能
    @Test
    void contextLoads2() {
        List<Scenery> sceneries = sceneryService.findAll();
        for (Scenery scenery:sceneries) {
            System.out.println(scenery);
        }
    }

    // 测试发布景点功能
    @Test
    void contextLoads3() {
        Scenery scenery = new Scenery();
        scenery.setTitle("圆明新园");
        scenery.setContent("圆明新园于公元一九九七年二月二日正式建成并开放，它坐落于珠海九洲大道石林山下，占地面积为１.３９平方公里，以北京圆明园为原稿，按１：１比例精选圆明园四十景中的十八景修建而成，投资６亿元人民币，是我国首批４Ａ级景区之一。它以其浓厚的清文化、精雅别致的亭、台、楼、阁和气势磅礴的大型舞蹈表演吸引了无数国内外游客。圆明新园融古典皇家建筑群、江南古典园林建筑群和西洋建筑群为一体，为游客再显了清朝盛世风华。园内西部，是独具高贵气质的西洋建筑群，白色的大理石墙身，精致的殿内装饰，让您仿佛置身于古老的欧洲宫殿。正大光明殿、九洲清宴景区等布局庄严、方正，或体现皇族气派、或展现后宫佳丽的脱俗气质；黄色的琉璃器宇轩昂；绿色的琉璃充满生机；紫色的琉璃驱鬼辟邪，难怪乾隆皇帝有“不雕不绘，自得轩茅舍意”。");
        scenery.setPhoto("https://picsum.photos/id/134/300/200");
        scenery.setCreatTime(new Date());
        scenery.setDescription("圆明新园于公元一九九七年二月二日正式建成并开放，它坐落于珠海九洲大道石林山下，占地面积为１.３９平方公里，以北京圆明园为原稿，按１：１比例精选圆明园四十景中的十八景修建而成，投资６亿元人民币，是我国首批４Ａ级景区之一。它以其浓...");

        sceneryService.add(scenery);
        System.out.println("success");
    }

    // 测试查询景点数功能
    @Test
    void contextLoads4() {
        int count = sceneryService.findCount();
        System.out.println(count);
    }

    // 测试分页查询景点功能
    @Test
    void contextLoads5() {
        List<Scenery> sceneries = sceneryService.findByLimit(0,5);
        for (Scenery scenery:sceneries) {
            System.out.println(scenery);
        }
    }

    // 测试根据id查询景点功能
    @Test
    void contextLoads6() {
        Scenery scenery = sceneryService.findById(1);
        System.out.println(scenery);
    }

    // 测试增加评论功能
    @Test
    void contextLoads7() {
        Comment comment = new Comment();

        comment.setSid(6);
        comment.setName("周先生");
        comment.setContent("这个景区不错哦，推荐来玩！");
        comment.setEmail("1910494800@qq.com");
        comment.setCreateTime(new Date());

        commentService.addComment(comment);
        System.out.println("success");
    }

    // 测试根据景点id查询其评论内容功能
    @Test
    void contextLoads8() {
        List<Comment> comments = commentService.findById(6);
        for (Comment comment:comments) {
            System.out.println(comment);
        }
    }

    // 测试根据关键词搜索景点功能
    @Test
    void contextLoads9() {
        List<Scenery> sceneries = sceneryService.findByQuery("长隆");
        for (Scenery scenery:sceneries) {
            System.out.println(scenery);
        }
    }


}
