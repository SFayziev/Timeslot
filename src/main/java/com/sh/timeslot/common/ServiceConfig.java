package com.sh.timeslot.common;


import com.sh.timeslot.common.enums.BaseStatus;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


//@PropertySource("classpath:applicationConstants.yml")
@ConfigurationProperties(prefix = "server")
@Data
@Validated
public class ServiceConfig {

    private Float version;
    private int port ;
    private Company company= new Company();

    public static class Company {
        private BaseStatus defaultStatus;

        public BaseStatus getDefaultStatus() {

            return defaultStatus;
        }

        public void setDefaultStatus(BaseStatus defaultStatus) {
            this.defaultStatus = defaultStatus;
        }
    }

}
