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

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mobile.esprit.tn.mobileteam.Models.Project;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.meeting.SingleChoiceProjetFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.SingleChoiceMembreFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;

/**
 * A page offering the user a number of mutually exclusive choices.
 */
public class SingleFixedChoiceProjetPage extends Page {
    String TAG = SingleFixedChoiceProjetPage.class.getSimpleName();
    protected ArrayList<Project> mChoices = new ArrayList<>();
    private ArrayList<Project> items = new ArrayList<>();
    Context context;

    public SingleFixedChoiceProjetPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
        prepareProjets();
    }

    @Override
    public Fragment createFragment() {
        return SingleChoiceProjetFragment.create(getKey());
    }

    public Project getOptionAt(int position) {
        return mChoices.get(position);
    }

    public int getOptionCount() {
        return mChoices.size();
    }


    public ArrayList<Project> getList_projets() {
        return items;
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem(getTitle(), mData.getString(SIMPLE_DATA_KEY), getKey()));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(SIMPLE_DATA_KEY));
    }

    public SingleFixedChoiceProjetPage setChoices(Project... choices) {
        mChoices.addAll(Arrays.asList(choices));
        return this;
    }

    public SingleFixedChoiceProjetPage setValue(String value) {
        mData.putString(SIMPLE_DATA_KEY, value);
        return this;
    }


 /*
                        ||=============================================||
                        ||                                             ||
                        ||                                             ||
                        ||                 All Patients                   ||
                        ||                                             ||
                        ||                                             ||
                        ||                                             ||
                        ||=============================================||*/

    /**
     * All Drugs
     */

    private void prepareProjets() {
        items.clear();

        Backendless.Persistence.of(Project.class).find(new AsyncCallback<BackendlessCollection<Project>>() {
            @Override
            public void handleResponse(BackendlessCollection<Project> foundProjets) {
                List<Project> projects = foundProjets.getCurrentPage();
                Log.v(TAG, String.valueOf(projects.size()));
                items.addAll(projects);
                Log.v(TAG, String.valueOf(items.size()));


            }

            @Override
            public void handleFault(BackendlessFault fault) {
// an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });


    }
}

