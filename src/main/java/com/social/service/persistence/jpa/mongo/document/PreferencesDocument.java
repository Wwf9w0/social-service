package com.social.service.persistence.jpa.mongo.document;

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
public class PreferencesDocument {

    private boolean profileOpen;
    private boolean showUserName;
    private boolean postCommentAllowed;
    private boolean postViewAllowedForEveryone;
}
