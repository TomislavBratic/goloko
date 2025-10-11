package com.example.goloko.admin_setting.web.request;

public record CreateAdminSettingRequest(
        String settingKey,
        String settingValue
) {
}
