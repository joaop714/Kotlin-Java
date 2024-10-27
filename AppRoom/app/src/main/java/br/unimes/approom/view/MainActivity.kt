package br.unimes.approom.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import br.unimes.approom.dao.UserDao
import br.unimes.approom.database.AppDatabase
import br.unimes.approom.databinding.ActivityMainBinding
import br.unimes.approom.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-approom"
        ).fallbackToDestructiveMigration()
            .build()
        userDao = db.userDao()

        binding.btnSave.setOnClickListener {
            val firstName = binding.edtFirstName.text.toString()
            val lastName = binding.edtLastName.text.toString()
            val user = User(0, firstName, lastName)
            lifecycleScope.launch {
                userDao.insertAll(user)
            }
            Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
        }
        binding.btnList.setOnClickListener {
            lifecycleScope.launch {
                val users = withContext(Dispatchers.IO){
                    userDao.getAll()
                }
                users.forEach {
                    Log.d("Users", it.toString())
                }
            }
        }
    }
}