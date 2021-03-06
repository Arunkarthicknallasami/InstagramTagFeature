/*
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tagfeature.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tagfeature.R;
import com.tagfeature.adapters.SomeOneAdapter;
import com.tagfeature.interfaces.SomeOneClickListener;
import com.tagfeature.models.SomeOne;
import com.tagfeature.utilities.SomeOneData;

public class SomeOneActivity extends AppCompatActivity implements SomeOneClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some_one);
        RecyclerView mRecyclerViewSomeOne = findViewById(R.id.rv_some_one);
        SomeOneAdapter someOneAdapter =
                new SomeOneAdapter(SomeOneData.getDummySomeOneList(),
                        this, this);
        mRecyclerViewSomeOne.setAdapter(someOneAdapter);
        mRecyclerViewSomeOne.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onSomeOneClicked(final SomeOne someOne, int position) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SomeOneActivity.this,
                        someOne.getFullName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
