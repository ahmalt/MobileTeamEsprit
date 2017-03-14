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

package mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.text.InputType;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mobile.esprit.tn.mobileteam.Models.Award;
import mobile.esprit.tn.mobileteam.Models.Technology;
import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.Page;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.MultipleFixedChoiceAwardPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.MultipleFixedChoiceTechnologyPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.ui.PageFragmentCallbacks;


public class MultipleChoiceAwardsFragment extends ListFragment {
    private static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private List<String> mChoices;
    private Page mPage;
    private ArrayList<Award> awardArrayList = new ArrayList<>();
    private TextView add_award;
    String nom, desc;

    public static MultipleChoiceAwardsFragment create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        MultipleChoiceAwardsFragment fragment = new MultipleChoiceAwardsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MultipleChoiceAwardsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = mCallbacks.onGetPage(mKey);


        final MultipleFixedChoiceAwardPage fixedChoicePage = (MultipleFixedChoiceAwardPage) mPage;
        awardArrayList = new ArrayList<>();
        awardArrayList = fixedChoicePage.getList_technology();
        if (awardArrayList.isEmpty()) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
            builder1.setMessage("NO Awards TO DISPLAY.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
        mChoices = new ArrayList<String>();
        for (int i = 0; i < awardArrayList.size(); i++) {

            fixedChoicePage.setChoices(awardArrayList.get(i));

            mChoices.add(fixedChoicePage.getOptionAt(i).getName());
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page_award, container, false);
        ((TextView) rootView.findViewById(android.R.id.title)).setText(mPage.getTitle());

        add_award = ((TextView) rootView.findViewById(R.id.add_award));

        final ListView listView = (ListView) rootView.findViewById(android.R.id.list);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice,
                android.R.id.text1,
                mChoices));
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Pre-select currently selected items.
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> selectedItems = mPage.getData().getStringArrayList(
                        Page.SIMPLE_DATA_KEY);
                if (selectedItems == null || selectedItems.size() == 0) {
                    return;
                }

                Set<String> selectedSet = new HashSet<String>(selectedItems);

                for (int i = 0; i < mChoices.size(); i++) {
                    if (selectedSet.contains(mChoices.get(i))) {
                        listView.setItemChecked(i, true);
                    }
                }
            }
        });
        add_award.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                builder.setTitle("NEW AWARD");

// Set up the input
                final EditText input_nom = new EditText(getActivity());
                final EditText input_description = new EditText(getActivity());

// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input_nom.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input_nom);

                input_description.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input_description);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nom = input_nom.getText().toString();
                        desc = input_description.getText().toString();
                        Award award = new Award();
                        award.setName(nom);
                        award.setDescription(desc);
                        awardArrayList.add(award);
                        //fixedChoicePage.notifyDataChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();


            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof PageFragmentCallbacks)) {
            throw new ClassCastException("Activity must implement PageFragmentCallbacks");
        }

        mCallbacks = (PageFragmentCallbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        SparseBooleanArray checkedPositions = getListView().getCheckedItemPositions();
        ArrayList<String> selections = new ArrayList<String>();
        for (int i = 0; i < checkedPositions.size(); i++) {
            if (checkedPositions.valueAt(i)) {
                selections.add(getListAdapter().getItem(checkedPositions.keyAt(i)).toString());
            }
        }

        mPage.getData().putStringArrayList(Page.SIMPLE_DATA_KEY, selections);
        mPage.notifyDataChanged();
    }


}