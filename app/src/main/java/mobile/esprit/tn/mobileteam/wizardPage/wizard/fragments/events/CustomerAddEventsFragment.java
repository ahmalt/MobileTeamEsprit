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

package mobile.esprit.tn.mobileteam.wizardPage.wizard.fragments.events;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.TeamUpApp;
import mobile.esprit.tn.mobileteam.Utile.TeamUp;
import mobile.esprit.tn.mobileteam.wizardPage.activty_wizard.evenement.AddEventActivity;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.events.CustomerAddEventsPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.news.CustomerAddNewsPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddProjectPage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.ui.PageFragmentCallbacks;

public class CustomerAddEventsFragment extends Fragment {
    private static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private CustomerAddEventsPage mPage;
    private TextView mTitreView;
    private TextView mTextView;
    private EditText nom_event,description,heure_debut,date_debut,heure_fin,date_fin;

    public static CustomerAddEventsFragment create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        CustomerAddEventsFragment fragment = new CustomerAddEventsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CustomerAddEventsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (CustomerAddEventsPage) mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page_add_event, container, false);
        ((TextView) rootView.findViewById(android.R.id.title)).setText(mPage.getTitle());

        nom_event = ((EditText) rootView.findViewById(R.id.nom_event));
        nom_event.setText(mPage.getData().getString(CustomerAddEventsPage.NOM_DATA_KEY));

        description = ((EditText) rootView.findViewById(R.id.description));
        description.setText(mPage.getData().getString(CustomerAddEventsPage.DESCRIPTION_DATA_KEY));


        date_debut = ((EditText) rootView.findViewById(R.id.date_debut));
        date_debut.setText(mPage.getData().getString(CustomerAddEventsPage.DATE_START_DATA_KEY));


        heure_debut = ((EditText) rootView.findViewById(R.id.heure_debut));
        heure_debut.setText(mPage.getData().getString(CustomerAddEventsPage.HEURE_START_DATA_KEY));


        date_fin = ((EditText) rootView.findViewById(R.id.date_fin));
        date_fin.setText(mPage.getData().getString(CustomerAddEventsPage.DATE_END_DATA_KEY));


        heure_fin = ((EditText) rootView.findViewById(R.id.heure_fin));
        heure_fin.setText(mPage.getData().getString(CustomerAddEventsPage.HEURE_END_DATA_KEY));

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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nom_event.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(CustomerAddEventsPage.NOM_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });
        description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(CustomerAddEventsPage.DESCRIPTION_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });
        date_debut.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(CustomerAddEventsPage.DATE_START_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();


            }


        });
        heure_debut.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(CustomerAddEventsPage.HEURE_START_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();


            }


        });
        date_fin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(CustomerAddEventsPage.DATE_END_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();


            }


        });
        heure_fin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(CustomerAddEventsPage.HEURE_END_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();


            }


        });
        date_debut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                            /*      Your code   to get date and time    */
                        date_debut.setText(selectedyear+"-"+selectedmonth+"-"+selectedday);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.getDatePicker().setCalendarViewShown(false);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });

        date_fin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth=mcurrentDate.get(Calendar.MONTH);
                int mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                            /*      Your code   to get date and time    */
                        date_fin.setText(selectedyear+"-"+selectedmonth+"-"+selectedday);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.getDatePicker().setCalendarViewShown(false);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });


        heure_debut.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate = Calendar.getInstance();
                int mHour = mcurrentDate.get(Calendar.HOUR_OF_DAY);
                int mMinute = mcurrentDate.get(Calendar.MINUTE);

                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        heure_debut.setText(hourOfDay + ":" + minute);
                    }
                },mHour,mMinute,true);

                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }

        });
        heure_fin.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate = Calendar.getInstance();
                int mHour = mcurrentDate.get(Calendar.HOUR_OF_DAY);
                int mMinute = mcurrentDate.get(Calendar.MINUTE);

                final TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        heure_fin.setText(hourOfDay + ":" + minute);
                    }
                },mHour,mMinute,true);

                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }

        });


    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        // instead of setMenuVisibility.
        if (nom_event != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            if (!menuVisible) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }
    }


}
