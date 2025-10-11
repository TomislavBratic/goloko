package com.example.goloko.admin_setting.application;

import com.example.goloko.admin_setting.domain.AdminSetting;
import com.example.goloko.admin_setting.domain.AdminSettingRepository;
import com.example.goloko.admin_setting.web.mapper.AdminSettingMapper;
import com.example.goloko.admin_setting.web.request.CreateAdminSettingRequest;
import com.example.goloko.admin_setting.web.response.CreateAdminSettingResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminSettingService {

    private final AdminSettingRepository repository;
    private final AdminSettingMapper mapper;

    public AdminSettingService(AdminSettingRepository repository, AdminSettingMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public CreateAdminSettingResponse create(CreateAdminSettingRequest request){

        AdminSetting setting = mapper.toEntity(request);
        repository.save(setting);

        return mapper.toResponse(setting);
    }
}
