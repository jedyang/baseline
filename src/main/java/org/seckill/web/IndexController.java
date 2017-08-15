package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author yunsheng
 */
@Controller//@Service @Component
@RequestMapping("/")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/tab1", method = RequestMethod.GET)
    public String tab1(Model model) {
        return "tab1";// /WEB-INF/jsp/"tab1".jsp
    }

    @RequestMapping(value = "/tab2", method = RequestMethod.GET)
    public String tab2(Model model) {
        return "tab2";
    }

    @RequestMapping(value = "/tab3", method = RequestMethod.GET)
    public String tab3(Model model) {
        return "tab3";
    }

    @RequestMapping(value = "/tab4", method = RequestMethod.GET)
    public String tab4(Model model) {
        return "tab4";
    }
}
