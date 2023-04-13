package com.example.materialdesign
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.materialdesign.UserDao

@Database(entites=[User::class],version=1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @volatile
        private var instance: UserDatabase? = null

        fun getDatabase(context: context): UserDatabase {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::Class.java,
                    "User_database "
                ).build()
                instance = newInstance
                newInstance
            }
        }
    }
}
