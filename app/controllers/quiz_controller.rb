class QuizController < ApplicationController
  def index
    @questions = OpenData::QuizBuilder.new.random_question_set_of_ten
  end
end
