package org.example.kun_uz.Service;

import org.example.kun_uz.Dto.RegionDto;
import org.example.kun_uz.Repository.RegionRepo;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.Region;
import org.example.kun_uz.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepo regionRepo;

    public List<Region> getall(){
        return regionRepo.findAll();
    }

    public Region getbyid(Integer id){
        Optional<Region> getid = regionRepo.findById(id);
        return getid.get();
    }
    public Result create(RegionDto regionDto){
        Region region = new Region();
        region.setOrder_number(regionDto.getOrder_number());
        region.setName_uz(regionDto.getName_uz());
        region.setName_ru(regionDto.getName_ru());
        region.setName_eng(regionDto.getName_eng());
        region.setCreated_date(regionDto.getCreated_date());
        regionRepo.save(region);
        return new Result(true, "Region created");
    }

    public Result update( Integer id, RegionDto regionDto){

        Optional<Region> regionOptional=regionRepo.findById(id);
        if(regionOptional.isPresent()){
            Region region=regionOptional.get();
            region.setOrder_number(regionDto.getOrder_number());
            region.setName_uz(regionDto.getName_uz());
            region.setName_ru(regionDto.getName_ru());
            region.setName_eng(regionDto.getName_eng());
            region.setCreated_date(regionDto.getCreated_date());
            regionRepo.save(region);
            return new Result(true, "Region updated");
        }

        return new Result(false, "Region not found");
    }

    public Result delete(Integer id){
        regionRepo.deleteById(id);
        return new Result(true, "Region deleted");
    }
}
