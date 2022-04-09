package com.social.service.persistence.jpa.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Preferences")
public class PreferencesEntity {

    private boolean profileOpen;
    private boolean showNickName;
    private boolean postCommentAllowed;
    private boolean postViewAllowedForEveryone;
}
