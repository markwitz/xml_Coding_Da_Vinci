require 'rails_helper'

describe OpenData::QuizBuilder do
  let (:questions) { OpenData::QuizBuilder.new.random_question_set_of_ten }

  it 'returns 10 questions' do
    expect(questions.size).to eq 10
  end

  context 'question containing' do
    let (:first_question) { questions.first }

    it 'contains title' do
      expect(first_question[:title]).to be_a String
      expect(first_question[:title].empty?).to be_falsey
    end

    context 'answers' do
      let(:answers) { first_question[:answers] }

      it 'contains 4 answers' do
        expect(answers.size).to eq 4
      end

      it 'has all answers titled' do
        answers.each do |answer|
          expect(answer[:title]).to be_a String
          expect(answer[:title].empty?).to be_falsey
        end
      end

      it 'has only one right answer' do
        right_answers = answers.map { |answer| answer[:right] }
        expect(right_answers.count(true)).to eq 1
      end
    end
  end
end
