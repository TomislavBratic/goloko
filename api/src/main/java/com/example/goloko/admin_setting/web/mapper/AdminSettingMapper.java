package com.example.goloko.admin_setting.web.mapper;

import com.example.goloko.admin_setting.domain.AdminSetting;
import com.example.goloko.admin_setting.web.request.CreateAdminSettingRequest;
import com.example.goloko.admin_setting.web.response.CreateAdminSettingResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminSettingMapper {
    AdminSetting toEntity(CreateAdminSettingRequest casr);
    CreateAdminSettingResponse toResponse(AdminSetting adminSetting);
}
