package com.sshtukin.layoutstask

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_constraint.*

/**
 * Fragment which showing FlightInfo, based on ConstraintLayout
 *
 * @author Sergey Shtukin
 */

class ConstraintFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_constraint, container, false)
    }

    override fun onStart() {
        super.onStart()
        arguments?.getParcelable<FlightInfo>(FLIGHTINFO_DEPART_KEY)?.let {
            tvDepartDate.text = it.date
            tvDepartFreeSeats.text = it.freeSeats
            tvDepartCost.text = it.cost
            tvDepartPlaceFrom.text = it.placeFrom
            tvDepartPlaceTo.text = it.placeTo
            tvDepartLeaveTime.text = it.departTime
            tvDepartArriveTime.text = it.arriveTime
            tvDepartTotalTime.text = it.totalTime
        }
        arguments?.getParcelable<FlightInfo>(FLIGHTINFO_RETURN_KEY)?.let {
            tvReturnDate.text = it.date
            tvReturnFreeSeats.text = it.freeSeats
            tvReturnCost.text = it.cost
            tvReturnPlaceFrom.text = it.placeFrom
            tvReturnPlaceTo.text = it.placeTo
            tvReturnLeaveTime.text = it.departTime
            tvReturnArriveTime.text = it.arriveTime
            tvReturnTotalTime.text = it.totalTime
        }
    }

    companion object {
        private val FLIGHTINFO_DEPART_KEY = "1001"
        private val FLIGHTINFO_RETURN_KEY = "1002"

        fun newInstance(departFlightInfo :FlightInfo, returnFlightInfo: FlightInfo) = ConstraintFragment().apply {
            arguments = Bundle().apply {
                putParcelable(FLIGHTINFO_DEPART_KEY, departFlightInfo)
                putParcelable(FLIGHTINFO_RETURN_KEY, returnFlightInfo)
            }
        }
    }
}