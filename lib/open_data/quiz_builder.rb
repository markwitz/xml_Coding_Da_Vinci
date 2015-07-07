class OpenData::QuizBuilder

  def initialize
    @parser = OpenData::Parser.new
    @informations = @parser.informations
    @authors = @parser.authors
  end

  def random_question_set_of_ten
    create_questions 10
  end

  private

  def create_questions(count)
    questions = []
    @question_type = :actor_name
    count.times do |inner_count|
      @current_index = inner_count
      questions << create_question
    end
    questions
  end

  def create_question
    {
      title: "Von wem ist dieses Bild?",
      flickr_link: @informations[@current_index][:flickr_link],
      answers: create_answers
    }
  end

  def create_answers
    @authors.delete(information_set)
    right_answer = answer(information_set, true)
    answers = four_wrong_answers
    reset_all_authors
    answers[rand(answers.count)] = right_answer
    answers
  end

  def four_wrong_answers
    answers = Array.new(4)
    answers.map! do |answer|
      answer(@authors.pop)
    end
  end

  def answer(title, right = false)
    { title: title, right: right }
  end

  def information_set
    @informations[@current_index][@question_type]
  end

  def reset_all_authors
    @authors = @parser.authors
  end
end
