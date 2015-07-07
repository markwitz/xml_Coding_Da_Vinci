class QuizController < ApplicationController
  def index
    @questions = OpenData::QuizBuilder.new.random_question_set_of_ten
    @image_links = image_links
  end

  private

  def image_links
    [
      "//c1.staticflickr.com/9/8732/16925072491_95a60eec91_n.jpg",
      "//c1.staticflickr.com/9/8721/16739861289_9384a14845_n.jpg",
      "//c2.staticflickr.com/8/7600/16306029323_a23e1fee21_n.jpg",
      "//c1.staticflickr.com/9/8743/16926073715_2124ba1099_n.jpg",
      "//c1.staticflickr.com/9/8688/16303678414_25d4cd2f31_n.jpg",
      "//c1.staticflickr.com/9/8729/16739857459_4a4a06aa88_n.jpg",
      "//c1.staticflickr.com/9/8746/16925067161_415ec76a52_n.jpg",
      "//c2.staticflickr.com/8/7650/16738390728_5e14a778cb_n.jpg",
      "//c2.staticflickr.com/8/7632/16738389998_f664e36951_n.jpg",
      "//c1.staticflickr.com/9/8731/16739853259_6927569b75_n.jpg",
    ]
  end
end
