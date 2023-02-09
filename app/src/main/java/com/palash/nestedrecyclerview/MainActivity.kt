package com.palash.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.palash.nestedrecyclerview.adapters.ParentAdapter
import com.palash.nestedrecyclerview.models.ChildDataClass
import com.palash.nestedrecyclerview.models.ParentDataClass
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val parentItemsList = ArrayList<ParentDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvParent = findViewById<RecyclerView>(R.id.rv_parent)
        rvParent.setHasFixedSize(true)
        rvParent.layoutManager = LinearLayoutManager(this)

        val adapter = ParentAdapter(parentItemsList)

        val searchView = findViewById<SearchView>(R.id.searchView)

        setData()

        rvParent.adapter = adapter


        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                val searchList = ArrayList<ParentDataClass>()


                if (newText != null){
                    for (i in parentItemsList){
                        if (i.title.lowercase(Locale.ROOT).contains(newText)){
                            searchList.add(i)
                        }
                    }
                    if (searchList.isEmpty()){
                        Toast.makeText(this@MainActivity, " No Data", Toast.LENGTH_SHORT).show()
                    }else{

                        adapter.onApplySearch(searchList)
                    }
                }



                return true
            }

        })
    }
    private fun setData() {

        val childItemsList = ArrayList<ChildDataClass>()

        childItemsList.add(ChildDataClass(R.drawable.book1))
        childItemsList.add(ChildDataClass(R.drawable.book3))
        childItemsList.add(ChildDataClass(R.drawable.book5))
        childItemsList.add(ChildDataClass(R.drawable.book7))
        childItemsList.add(ChildDataClass(R.drawable.book9))
        childItemsList.add(ChildDataClass(R.drawable.book11))
        childItemsList.add(ChildDataClass(R.drawable.book13))

        parentItemsList.add(ParentDataClass("Best seller:", childItemsList))


        val childItemsList2 = ArrayList<ChildDataClass>()

        childItemsList2.add(ChildDataClass(R.drawable.book6))
        childItemsList2.add(ChildDataClass(R.drawable.book4))
        childItemsList2.add(ChildDataClass(R.drawable.book2))
        childItemsList2.add(ChildDataClass(R.drawable.book8))
        childItemsList2.add(ChildDataClass(R.drawable.book10))
        childItemsList2.add(ChildDataClass(R.drawable.book12))
        childItemsList2.add(ChildDataClass(R.drawable.book14))

        parentItemsList.add(ParentDataClass("History:", childItemsList2))

        val childItemsList3 = ArrayList<ChildDataClass>()

        childItemsList3.add(ChildDataClass(R.drawable.book10))
        childItemsList3.add(ChildDataClass(R.drawable.book12))
        childItemsList3.add(ChildDataClass(R.drawable.book7))
        childItemsList3.add(ChildDataClass(R.drawable.book8))
        childItemsList3.add(ChildDataClass(R.drawable.book11))
        childItemsList3.add(ChildDataClass(R.drawable.book4))
        childItemsList3.add(ChildDataClass(R.drawable.book14))

        parentItemsList.add(ParentDataClass("Favorite:", childItemsList3))

        val childItemsList4 = ArrayList<ChildDataClass>()

        childItemsList4.add(ChildDataClass(R.drawable.book9))
        childItemsList4.add(ChildDataClass(R.drawable.book13))
        childItemsList4.add(ChildDataClass(R.drawable.book12))
        childItemsList4.add(ChildDataClass(R.drawable.book8))
        childItemsList4.add(ChildDataClass(R.drawable.book11))
        childItemsList4.add(ChildDataClass(R.drawable.book4))
        childItemsList4.add(ChildDataClass(R.drawable.book14))

        parentItemsList.add(ParentDataClass("Drama:", childItemsList4))

        val childItemsList5 = ArrayList<ChildDataClass>()

        childItemsList5.add(ChildDataClass(R.drawable.book14))
        childItemsList5.add(ChildDataClass(R.drawable.book1))
        childItemsList5.add(ChildDataClass(R.drawable.book5))
        childItemsList5.add(ChildDataClass(R.drawable.book8))
        childItemsList5.add(ChildDataClass(R.drawable.book6))
        childItemsList5.add(ChildDataClass(R.drawable.book14))
        childItemsList5.add(ChildDataClass(R.drawable.book4))

        parentItemsList.add(ParentDataClass("Crime:", childItemsList5))

        val childItemsList6 = ArrayList<ChildDataClass>()

        childItemsList6.add(ChildDataClass(R.drawable.book11))
        childItemsList6.add(ChildDataClass(R.drawable.book10))
        childItemsList6.add(ChildDataClass(R.drawable.book9))
        childItemsList6.add(ChildDataClass(R.drawable.book8))
        childItemsList6.add(ChildDataClass(R.drawable.book7))
        childItemsList6.add(ChildDataClass(R.drawable.book4))
        childItemsList6.add(ChildDataClass(R.drawable.book14))

        parentItemsList.add(ParentDataClass("Novel:", childItemsList6))

    }
}