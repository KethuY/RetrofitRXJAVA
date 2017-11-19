package com.tallrocket.trial.profile;

import com.tallrocket.trial.models.Comment;

import java.util.List;

/**
 * Created by user on 11/17/17.
 */

public interface ProfileView {
    void loadData(List<Comment> comments);
}
