package org.example.kun_uz.Controller;

import org.example.kun_uz.Dto.RegionDto;
import org.example.kun_uz.Service.RegionService;
import org.example.kun_uz.model.Region;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService regionService;
    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getall();
    }
    @GetMapping("/{id}")
    public Region getRegionById(Integer id) {
        return regionService.getbyid(id);
    }
    @PostMapping
    public Result getRegionByName(RegionDto regionDto) {
        Result result=regionService.create(regionDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateRegion(Integer id , RegionDto regionDto) {
         Result result=regionService.update(id, regionDto);
         return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteRegion(Integer id) {
        Result result=regionService.delete(id);
        return result;
    }
}
