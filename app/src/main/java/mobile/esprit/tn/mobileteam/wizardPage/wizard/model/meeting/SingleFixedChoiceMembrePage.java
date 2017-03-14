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

import com.backendless.BackendlessUser;

import java.util.ArrayList;
import java.util.Arrays;

import mobile.esprit.tn.mobileteam.Models.Technology;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project.SingleChoiceMembreFragment;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ModelCallbacks;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.ReviewItem;

/**
 * A page offering the user a number of mutually exclusive choices.
 */
public class SingleFixedChoiceMembrePage extends Page {
    String TAG = SingleFixedChoiceMembrePage.class.getSimpleName();
    protected ArrayList<BackendlessUser> mChoices = new ArrayList<>();
    private ArrayList<BackendlessUser> items = new ArrayList<>();
    Context context;

    public SingleFixedChoiceMembrePage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return SingleChoiceMembreFragment.create(getKey());
    }

    public BackendlessUser getOptionAt(int position) {
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

    public SingleFixedChoiceMembrePage setChoices(BackendlessUser... choices) {
        mChoices.addAll(Arrays.asList(choices));
        return this;
    }

    public SingleFixedChoiceMembrePage setValue(String value) {
        mData.putString(SIMPLE_DATA_KEY, value);
        return this;
    }



}