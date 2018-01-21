package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import kotlinx.android.synthetic.main.fragment_fab_trans.view.*
import android.support.design.widget.FloatingActionButton
import kotlinx.android.synthetic.main.dialog.view.*
import kotlinx.android.synthetic.main.fragment_fab_trans.*
import tech.ketc.animkt.extension.animator.FabRevealTransform


class FABTransFragment : Fragment() {

    private val transform by lazy {
        val theme = context!!.theme
        val fabColor = resources.getColor(R.color.colorAccent, theme)
        val targetColor = resources.getColor(R.color.cardview_dark_background, theme)
        FabRevealTransform(fab as FloatingActionButton, dialog, fabColor, targetColor)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_fab_trans, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.fab.setOnClickListener {
            transform.start()
        }
        dialog.login_button.setOnClickListener {
            transform.start()
        }
    }
}