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

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mobile.esprit.tn.mobileteam.Models.Technology;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.SingleChoiceMembreFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.SingleChoiceTechnologyFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.ui.SingleChoiceFragment;

/**
 * A page offering the user a number of mutually exclusive choices.
 */
public class SingleFixedChoiceTechnologyPage extends Page {
    String TAG = SingleFixedChoiceTechnologyPage.class.getSimpleName();
    protected ArrayList<Technology> mChoices = new ArrayList<>();
    private ArrayList<Technology> technologyArrayList = new ArrayList<>();
    Context context;

    public SingleFixedChoiceTechnologyPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
        prepareTechnology();
    }
    public ArrayList<Technology> getList_technology() {
        return technologyArrayList;
    }

    @Override
    public Fragment createFragment() {
        return SingleChoiceTechnologyFragment.create(getKey());
    }

    public Technology getOptionAt(int position) {
        return mChoices.get(position);
    }

    public int getOptionCount() {
        return mChoices.size();
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem(getTitle(), mData.getString(SIMPLE_DATA_KEY), getKey()));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(SIMPLE_DATA_KEY));
    }

    public SingleFixedChoiceTechnologyPage setChoices(Technology... choices) {
        mChoices.addAll(Arrays.asList(choices));
        return this;
    }

    public SingleFixedChoiceTechnologyPage setValue(String value) {
        mData.putString(SIMPLE_DATA_KEY, value);
        return this;
    }
    /**
     * All technologies
     */

    private void prepareTechnology() {
        technologyArrayList.clear();

        Backendless.Persistence.of(Technology.class).find(new AsyncCallback<BackendlessCollection<Technology>>() {
            @Override
            public void handleResponse(BackendlessCollection<Technology> foundtechnologies) {
                List<Technology> technologies = foundtechnologies.getCurrentPage();
                Log.v(TAG, String.valueOf(technologies.size()));
                technologyArrayList.addAll(technologies);
                Log.v(TAG, String.valueOf(technologyArrayList.size()));


            }

            @Override
            public void handleFault(BackendlessFault fault) {
// an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });


    }
}