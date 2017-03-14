/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mobile.esprit.tn.mobileteam.wizardPage.wizard.model.meeting;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.List;

import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.meeting.MultipleChoiceMembresFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.*;

/**
 * A page offering the user a number of non-mutually exclusive choices.
 */
public class MultipleFixedChoiceMembrePage extends mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.SingleFixedChoiceMembrePage {
    String TAG =MultipleFixedChoiceMembrePage.class.getSimpleName();
    private ArrayList<BackendlessUser> userArrayList=new ArrayList<>();

    public MultipleFixedChoiceMembrePage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
        prepareMembres();
    }

    @Override
    public Fragment createFragment() {
        return MultipleChoiceMembresFragment.create(getKey());
    }
    public ArrayList<BackendlessUser> getList_users() {
        return userArrayList;
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        StringBuilder sb = new StringBuilder();

        ArrayList<String> selections = mData.getStringArrayList(Page.SIMPLE_DATA_KEY);
        if (selections != null && selections.size() > 0) {
            for (String selection : selections) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(selection);
            }
        }

        dest.add(new ReviewItem(getTitle(), sb.toString(), getKey()));
    }

    @Override
    public boolean isCompleted() {
        ArrayList<String> selections = mData.getStringArrayList(Page.SIMPLE_DATA_KEY);
        return selections != null && selections.size() > 0;
    }



 /*
                        ||=============================================||
                        ||                                             ||
                        ||                                             ||
                        ||                 All users            ||
                        ||                                             ||
                        ||                                             ||
                        ||                                             ||
                        ||=============================================||*/

    /**
     * All users
     */

    private void prepareMembres() {
        userArrayList.clear();

        Backendless.Persistence.of(BackendlessUser.class).find(new AsyncCallback<BackendlessCollection<BackendlessUser>>() {
            @Override
            public void handleResponse(BackendlessCollection<BackendlessUser> foundusers) {
                List<BackendlessUser> users = foundusers.getCurrentPage();
                Log.v(TAG, String.valueOf(users.size()));
                userArrayList.addAll(users);
                Log.v(TAG, String.valueOf(userArrayList.size()));
            }

            @Override
            public void handleFault(BackendlessFault fault) {
// an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });


    }
}



