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
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kimo.lib.alexei.Alexei;
import com.kimo.lib.alexei.Answer;
import com.kimo.lib.alexei.calculus.DominantColorCalculus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.TeamUpApp;
import  mobile.esprit.tn.mobileteam.utils.Utility;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.model.project.CustomerAddProjectImagePage;
import mobile.esprit.tn.mobileteam.wizardPage.wizard.ui.PageFragmentCallbacks;

public class CustomerAddProjetImageFragment extends Fragment {
    String TAG=CustomerAddProjetImageFragment.class.getSimpleName();
    private static final String ARG_KEY = "key";
    private String KEY_IMAGE = "image";
    private String KEY_NAME = "name";
    private Boolean DomColCal = false;
    Integer DominanteColor;


    private String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Boolean ImgChoise = false;
    Bitmap bmImage ;



    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private CustomerAddProjectImagePage mPage;


    private EditText mTitreView;

    private ImageView mImageView;


    Context context;

    public static CustomerAddProjetImageFragment create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        CustomerAddProjetImageFragment fragment = new CustomerAddProjetImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CustomerAddProjetImageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TeamUpApp.getInstance().getPrefManager().storeImageArticle("");
        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (CustomerAddProjectImagePage) mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_page_add_projet_image, container, false);
        ((TextView) rootView.findViewById(android.R.id.title)).setText(mPage.getTitle());
        mImageView = ((ImageView) rootView.findViewById(R.id.img_article));
        mTitreView = ((EditText) rootView.findViewById(R.id.name_photo));
//
        mImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectImage();
                System.out.println("Adding photo");
                //mTitreView.setText(getStringImage(bmImage));



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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTitreView.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                    int i2) {
           }
         @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           }

            @Override
           public void afterTextChanged(Editable editable) {
               mPage.getData().putString(CustomerAddProjectImagePage.IMAGE_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
               mPage.notifyDataChanged();
           }
       });





    }
    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

        // In a future update to the support library, this should override setUserVisibleHint
        // instead of setMenuVisibility.
//        if (mTitreView != null) {
//            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
//                    Context.INPUT_METHOD_SERVICE);
//            if (!menuVisible) {
//                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
//            }
//        }
    }
    private void selectImage() {
        ImgChoise = true;
        final CharSequence[] items = {"Take Photo", "Choose from Library","Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = Utility.checkPermission(getActivity());
                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    if (result)
                        cameraIntent();
                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    if (result)
                        galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Loading...", "Please wait...", false, false);
        bmImage = thumbnail;
        mImageView.setImageBitmap(thumbnail);

        if (ImgChoise) {
           // TeamUpApp.getInstance().getPrefManager().storeImageArticle(getStringImage(bmImage));
            Alexei.with(getActivity())
                    .analyze(mImageView)
                    .perform(new DominantColorCalculus(thumbnail))
                    .showMe(new Answer<Integer>() {
                        @Override
                        public void beforeExecution() {
                            // setContentShown(false);
                            Log.i(TAG,"performCalculus beforeExecution");
                        }

                        @Override
                        public void afterExecution(Integer answer, long elapsedTime) {
                            loading.dismiss();
                            try {

                                Log.i(TAG,"performCalculus afterExecution Integer = " +answer);
                                DomColCal = true;
                                DominanteColor = answer;
                              //  TeamUpApp.getInstance().getPrefManager().storedominantColor(DominanteColor);
                          Log.v(TAG,"DominanteColor"+DominanteColor);

                            } catch (NullPointerException e){}
                        }

                        @Override
                        public void ifFails(Exception error) {
                            loading.dismiss();
                        }
                    });
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Loading...", "Please wait...", false, false);
        bmImage = bm;
        mImageView.setImageBitmap(bm);


        if (ImgChoise) {
           // TeamUpApp.getInstance().getPrefManager().storeImageArticle(getStringImage(bmImage));

            Alexei.with(getActivity())
                    .analyze(mImageView)
                    .perform(new DominantColorCalculus(bm))
                    .showMe(new Answer<Integer>() {
                        @Override
                        public void beforeExecution() {
                            // setContentShown(false);
                            Log.i(TAG,"performCalculus beforeExecution");
                        }

                        @Override
                        public void afterExecution(Integer answer, long elapsedTime) {
                            loading.dismiss();
                            try {

                                Log.i(TAG,"performCalculus afterExecution Integer = " +answer);
                                DomColCal = true;
                                DominanteColor = answer;
                            // TeamUpApp.getInstance().getPrefManager().storedominantColor(DominanteColor);
                                Log.v(TAG,"DominanteColor"+DominanteColor);

                            } catch (NullPointerException e){}
                        }

                        @Override
                        public void ifFails(Exception error) {
                            loading.dismiss();
                        }
                    });








        }
    }
    }



