package com.tallrocket.trial.profile;

import com.tallrocket.trial.main.Employee;
import com.tallrocket.trial.models.Comment;

/**
 * Created by user on 11/15/17.
 */

public interface OnItemClick {
    void navigateToNextPage(int pos, Comment employee);
}
