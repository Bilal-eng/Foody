package com.example.foody.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import coil.load
import com.example.foody.R
import com.example.foody.models.Result
import org.jsoup.Jsoup

class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")

        val mainImageView = view.findViewById<ImageView>(R.id.main_imageView)
        val vegetarianImageView = view.findViewById<ImageView>(R.id.vegetarian_imageView)
        val veganImageView = view.findViewById<ImageView>(R.id.vegan_imageView)
        val glutenFreeImageView = view.findViewById<ImageView>(R.id.gluten_free_imageView)
        val dairyFreeImageView = view.findViewById<ImageView>(R.id.dairy_free_imageView)
        val healthyImageView = view.findViewById<ImageView>(R.id.healthy_imageView)
        val cheapImageView = view.findViewById<ImageView>(R.id.cheap_imageView)
        val titleTextView = view.findViewById<TextView>(R.id.title_textView)
        val likesTextView = view.findViewById<TextView>(R.id.likes_textView)
        val timeTextView = view.findViewById<TextView>(R.id.time_textView)
        val summaryTextView = view.findViewById<TextView>(R.id.summary_textView)
        val vegetarianTextView = view.findViewById<TextView>(R.id.vegetarian_textView)
        val veganTextView = view.findViewById<TextView>(R.id.vegan_textView)
        val glutenFreeTextView = view.findViewById<TextView>(R.id.gluten_free_textView)
        val dairyFreeTextView = view.findViewById<TextView>(R.id.dairy_free_textView)
        val healthyTextView = view.findViewById<TextView>(R.id.healthy_textView)
        val cheapTextView = view.findViewById<TextView>(R.id.cheap_textView)
        mainImageView.load(myBundle?.image)
        titleTextView.text = myBundle?.title
        likesTextView.text = myBundle?.aggregateLikes.toString()
        timeTextView.text = myBundle?.readyInMinutes.toString()
        myBundle?.summary.let {
            val summary = Jsoup.parse(it).text()
            summaryTextView.text = summary
        }

        if (myBundle?.vegetarian == true) {
            vegetarianImageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            vegetarianTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }

        if (myBundle?.vegan == true) {
            veganImageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            veganTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }

        if (myBundle?.glutenFree == true) {
            glutenFreeImageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            glutenFreeTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }

        if (myBundle?.dairyFree == true) {
            dairyFreeImageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            dairyFreeTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }

        if (myBundle?.veryHealthy == true) {
            healthyImageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            healthyTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }

        if (myBundle?.cheap == true) {
            cheapImageView.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            cheapTextView.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
        }

        return view
    }

}