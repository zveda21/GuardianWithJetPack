package com.example.guardianchangeapp

import com.google.gson.annotations.SerializedName

data class SectionResponse(

	@field:SerializedName("response")
	val response: Response? = null
)

data class ActiveSponsorshipsItem(

	@field:SerializedName("aboutLink")
	val aboutLink: String? = null,

	@field:SerializedName("sponsorLogoDimensions")
	val sponsorLogoDimensions: SponsorLogoDimensions? = null,

	@field:SerializedName("sponsorName")
	val sponsorName: String? = null,

	@field:SerializedName("sponsorLink")
	val sponsorLink: String? = null,

	@field:SerializedName("sponsorshipType")
	val sponsorshipType: String? = null,

	@field:SerializedName("sponsorLogo")
	val sponsorLogo: String? = null,

	@field:SerializedName("validFrom")
	val validFrom: String? = null,

	@field:SerializedName("validTo")
	val validTo: String? = null
)


data class ResultsItem(

	@field:SerializedName("editions")
	val editions: List<EditionsItem?>? = null,

	@field:SerializedName("apiUrl")
	val apiUrl: String? = null,

	@field:SerializedName("webUrl")
	val webUrl: String? = null,

	@field:SerializedName("webTitle")
	val webTitle: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("activeSponsorships")
	val activeSponsorships: List<ActiveSponsorshipsItem?>? = null,

	@field:SerializedName("favorite")
	var favorite: Boolean
)

data class EditionsItem(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("apiUrl")
	val apiUrl: String? = null,

	@field:SerializedName("webUrl")
	val webUrl: String? = null,

	@field:SerializedName("webTitle")
	val webTitle: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class Response(

	@field:SerializedName("userTier")
	val userTier: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class SponsorLogoDimensions(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("height")
	val height: Int? = null
)
