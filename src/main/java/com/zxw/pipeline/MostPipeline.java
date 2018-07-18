package com.zxw.pipeline;

import com.zxw.entity.Information;
import com.zxw.repository.MostRepo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MostPipeline implements Pipeline {
    @Resource
    private MostRepo mostRepo;
    @Override
    public void process(ResultItems resultItems, Task task){
        List<Information> informationList=resultItems.get("informationLists");
        if(informationList!=null){
            mostRepo.save(informationList);
        }
    }
}
