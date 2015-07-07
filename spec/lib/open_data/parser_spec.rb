require 'open_data/parser'
require 'nokogiri'

describe OpenData::Parser do
  let(:parser) { OpenData::Parser.new }
  let(:informations) { parser.informations }

  it 'has informations packed in an array' do
    expect(informations).to be_a Array
  end

  it 'has same count of array elements as open data xml files' do
    xml_file_count = Dir["config/open_data_xml/*.xml"].length
    expect(informations.count).to eq xml_file_count
  end

  it 'returns all other uniq' do
    authors = parser.authors
    expect(authors).to be_a Array
    expect(authors.uniq.count).to eq(authors.count)
  end
end
