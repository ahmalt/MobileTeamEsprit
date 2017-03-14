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

package mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.List;

import mobile.esprit.tn.mobileteam.Models.Award;
import mobile.esprit.tn.mobileteam.Models.Technology;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.MultipleChoiceAwardsFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.MultipleChoiceTechnologyFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;

/**
 * A page offering the user a number of non-mutually exclusive choices.
 */
public class MultipleFixedChoiceAwardPage extends SingleFixedChoiceAwardPage {
    String TAG =MultipleFixedChoiceAwardPage.class.getSimpleName();
    private ArrayList<Award> awardsArrayList=new ArrayList<>();

    public MultipleFixedChoiceAwardPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
        prepareAwards();
    }

    @Override
    public Fragment createFragment() {
        return MultipleChoiceAwardsFragment.create(getKey());
    }
    public ArrayList<Award> getList_technology() {
        return awardsArrayList;
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
                        ||                 All awards            ||
                        ||                                             ||
                        ||                                             ||
                        ||                                             ||
                        ||=============================================||*/

    /**
     * All awards
     */

    private void prepareAwards() {
        awardsArrayList.clear();

        Backendless.Persistence.of(Award.class).find(new AsyncCallback<BackendlessCollection<Award>>() {
            @Override
            public void handleResponse(BackendlessCollection<Award> foundtechnologies) {
                List<Award> awards = foundtechnologies.getCurrentPage();
                Log.v(TAG, String.valueOf(awards.size()));
                awardsArrayList.addAll(awards);
                Log.v(TAG, String.valueOf(awardsArrayList.size()));


            }

            @Override
            public void handleFault(BackendlessFault fault) {
// an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });


    }
}



