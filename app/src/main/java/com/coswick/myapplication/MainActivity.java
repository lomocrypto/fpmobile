package com.coswick.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter adapter;
    private ArrayList<Model> lstResep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lstResep = new ArrayList<>();
        lstResep.add(new Model("Wonder Woman 1984 ","Action","Description Resep",R.drawable.wonder_woman));
        lstResep.add(new Model("Black Widow","Action","Description At birth the Black Widow (aka Natasha Romanova) is given to the KGB, which grooms her to become its ultimate operative. When the U.S.S.R. breaks up, the government tries to kill her as the action moves to present-day New York, where she is a freelance operative. The standalone film will find Romanoff living in the United States 15 years after the fall of the Soviet Union.",R.drawable.black_widow));
        lstResep.add(new Model("Bird of Prey","Action","Description After splitting up with The Joker, Harley Quinn and three other female superheroes - Black Canary, Huntress and Renee Montoya - come together to save the life of a little girl (Cassandra Cain) from an evil crime lord called Black Mask.",R.drawable.birds_of_prey));
        lstResep.add(new Model("Bad Boys for Live","Action","Description In this third stallmment of Bad Boys franchise the Bad Boys Mike Lowrey (Will Smith) and Marcus Burnett (Martin Lawrence) are back together for one last ride.",R.drawable.bad_boy_for_live));
        lstResep.add(new Model("Hallowen Kills","Horror","Description Sequel to Halloween (2018)",R.drawable.halloween_kills));
        lstResep.add(new Model("The Spongebob Movie: Spongebob on the Run","Cartoon","Description This is the third feature film in the 'SpongeBob SquarePants' franchise based on the popular TV series.",R.drawable.the_spongebob_movie_spongebob_on_the_run));
        lstResep.add(new Model("The Conjuring the Devil Made me do It","Horror","Description Third installment of the Conjuring franchise",R.drawable.the_conjuring_the_devil_made_me_do_it));
        lstResep.add(new Model("Jumanji the Next Level","Catregorue REsep","Description This time, they get sent back into the game but the characters are switched - different people end up with the same avatars from the first one. But where is everyone else? We'll have to play to find out exactly what's going on here",R.drawable.jumanji_the_next_level));
        lstResep.add(new Model("King Kong vs Godzilla","Action","Description As the gigantic Kong meets the unstoppable Godzilla, the world watches to see which one of them will become King of the Monsters",R.drawable.kingkong_vs_godzila));


        RecyclerView myrv = findViewById(R.id.recyclerview_id);

        adapter = new RecyclerViewAdapter(this,lstResep);

        myrv.setAdapter(adapter);

        myrv.setLayoutManager(new GridLayoutManager(this,2));

        myrv.setHasFixedSize(true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

}
