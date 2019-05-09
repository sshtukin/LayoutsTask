package com.sshtukin.layoutstask

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_constraint.*
import kotlinx.android.synthetic.main.fragment_non_constraint.*
import kotlinx.android.synthetic.main.fragment_non_constraint.tvDepartArriveTime
import kotlinx.android.synthetic.main.fragment_non_constraint.tvDepartCost
import kotlinx.android.synthetic.main.fragment_non_constraint.tvDepartDate
import kotlinx.android.synthetic.main.fragment_non_constraint.tvDepartFreeSeats
import kotlinx.android.synthetic.main.fragment_non_constraint.tvDepartPlaceFrom
import kotlinx.android.synthetic.main.fragment_non_constraint.tvDepartPlaceTo
import kotlinx.android.synthetic.main.fragment_non_constraint.tvDepartTotalTime
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnArriveTime
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnCost
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnDate
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnFreeSeats
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnLeaveTime
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnPlaceFrom
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnPlaceTo
import kotlinx.android.synthetic.main.fragment_non_constraint.tvReturnTotalTime

/**
 * Fragment which showing FlightInfo, based on LinearLayouts
 *
 * @author Sergey Shtukin
 */

class NonConstraintFragment : Fragment(){

    private lateinit var listener: FABListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FABListener){
            listener = context
        }
        else {
            throw RuntimeException()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_non_constraint, container, false)
    }

    override fun onStart() {
        super.onStart()
        arguments?.getParcelable<FlightInfo>(FLIGHTINFO_DEPART_KEY)?.let {
                tvDepartDate.text = it.date
                tvDepartFreeSeats.text = it.freeSeats
                tvDepartCost.text = it.cost
                tvDepartPlaceFrom.text = it.placeFrom
                tvDepartPlaceTo.text = it.placeTo
                tvDepartDepartTime.text = it.departTime
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton.setOnClickListener {
            listener.onFABClicked()
        }
    }

    companion object {
        private const val FLIGHTINFO_DEPART_KEY = "1001"
        private const val FLIGHTINFO_RETURN_KEY = "1002"

        fun newInstance(departFlightInfo :FlightInfo, returnFlightInfo: FlightInfo) = NonConstraintFragment().apply {
            arguments = Bundle().apply {
                putParcelable(FLIGHTINFO_DEPART_KEY, departFlightInfo)
                putParcelable(FLIGHTINFO_RETURN_KEY, returnFlightInfo)
            }
        }
    }
}