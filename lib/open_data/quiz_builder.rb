class OpenData::QuizBuilder

  def initialize
    @informations = OpenData::Parser.new.informations
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
    answers = Array.new(4)
    right_answer = { title: information_set, right: true }
    answers.map! do
      @current_index += 1
      {
        title: information_set,
        right: false
      }
    end
    answers[2] = right_answer
    answers
  end

  def information_set
    @informations[@current_index][@question_type]
  end
end
