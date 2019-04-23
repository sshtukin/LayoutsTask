package com.sshtukin.layoutstask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity which contains buttons to start [ConstraintFragment] and [NonConstraintFragment]
 *
 * @author Sergey Shtukin
 */

class MainActivity : AppCompatActivity() {

    private fun setFragment(fragment: Fragment,
                            holderId: Int = R.id.fragmentHolder){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHolder, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            setFragment(ConstraintFragment.newInstance(departFlightInfo, returnFlightInfo))
        }

        btnFragment1.setOnClickListener {
            setFragment(ConstraintFragment.newInstance(departFlightInfo, returnFlightInfo))
        }

        btnFragment2.setOnClickListener {
            setFragment(NonConstraintFragment.newInstance(departFlightInfo, returnFlightInfo))
        }
    }

    private companion object {
        private val departFlightInfo = FlightInfo("16 sep 2019",
                                                    "3",
                                                    "435 BYN",
                                                    "MSQ",
                                                    "FLO",
                                                    "00:20",
                                                    "09:20",
                                                    "9:00")

        private val returnFlightInfo = FlightInfo("17 sep 2019",
                                                    "5",
                                                    "488 BYN",
                                                    "FLO",
                                                    "MSQ",
                                                    "05:10",
                                                    "09:20",
                                                    "4:10")
    }
}
